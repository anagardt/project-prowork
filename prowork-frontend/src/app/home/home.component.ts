import {Component, OnInit, Renderer2} from '@angular/core';
import {IssueService} from '../issue.service';
import {Issue} from '../model/issue';
import {CommentService} from '../comment.service';
import {Comment} from '../model/comment';
import {User} from '../model/user';
import {Project} from "../model/project";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  username: string;
  issues: Issue[];
  allIssues: Issue[];
  selectedIssue: Issue = undefined;
  selectedProject: Project = undefined;
  selectedIssueComments: Comment[];
  status: string;
  userField: string;
  projectId: number;
  comment = '';
  allUsers: User[] = [];
  allProjects: Project[] = [];

  constructor(private issueService: IssueService,
              private commentService: CommentService,
              private renderer: Renderer2) {
  }

  ngOnInit() {
    this.username = localStorage.getItem('User');
    this.issueService.getAllIssues()
      .subscribe((issues: Issue[]) => {
          this.issues = issues;
          this.allIssues = issues;
        },
        (error: any) => console.error(error));
    this.issueService.getAllUsers()
      .subscribe((users: User[]) => {
        this.allUsers = users;
      }, (error: any) => {
        console.error(error);
      });
    this.issueService.getAllProjects()
      .subscribe((projects: Project[]) => {
        this.allProjects = projects;
      }, (error: any) => {
        console.error(error);
      });
  }

  selectIssue(issue: Issue): void {
    this.selectedIssue = issue;
    this.renderer.addClass(document.getElementById('task-main'), 'task-main-half');
    this.commentService.getAllCommentsByIssueId(issue.issueId)
      .subscribe((comments: Comment[]) => {
          this.selectedIssueComments = comments;
        },
        (error: any) => console.error(error));
  }

  changeUserField(userField: string): void {
    this.userField = userField;
    this.filterIssues();
  }

  changeStatus(status: string): void {
    this.status = status;
    this.filterIssues();
  }

  changeSelectedProject(selectedProject: Project): void {
    this.selectedProject = selectedProject;
    this.filterIssues();
  }

  filterIssues(): void {
    const username = localStorage.getItem('User');

    this.issues = this.allIssues;

    if(this.selectedProject !== undefined) {
      this.issues = this.issues.filter((issues: Issue) => issues.project.projectId === this.selectedProject.projectId)
    }

    if (this.userField === 'assigned') {
      this.issues = this.issues.filter((issue: Issue) => issue.assignedTo.username === username);
    } else if (this.userField === 'created') {
      this.issues = this.issues.filter((issue: Issue) => issue.createdBy.username === username);
    } else if (this.userField === 'review') {
      this.issues = this.issues.filter((issue: Issue) => issue.reviewedBy.username === username);
    }

    if (this.status !== undefined && this.status !== 'ALL') {
      this.issues = this.issues.filter((issue: Issue) => issue.status === this.status);
    }

  }

  addComment() {
    const formData = new FormData();
    formData.set('commentText', this.comment);
    formData.set('issue','' + this.selectedIssue.issueId);
    this.commentService.addComment(formData)
      .subscribe((comment: Comment) => {
        this.selectedIssueComments.push(comment);
        this.comment = '';
      }, (error: any) => console.error(error));
  }

  discardComment() {
    this.comment = '';
  }

  deleteComment(commentId: number) {
    const formData = new FormData();
    formData.set('commentId', '' + commentId);
    this.commentService.deleteComment(formData)
      .subscribe((deletedComments) => {
        this.selectedIssueComments = this.selectedIssueComments.filter((value: Comment) => value.commentId !== commentId);
      }, (error: any) => {
        console.error(error);
      });
  }

  changeIssueStatus(statusCode: number) {
    const formData = new FormData();
    formData.set('issueId', '' + this.selectedIssue.issueId);
    formData.set('statusCode', '' + statusCode);
    this.issueService.changeIssueStatus(formData)
      .subscribe((issue: Issue) => {
        this.selectedIssue.status = issue.status;
      }, (error: any) => {
        console.error(error);
      });
  }

  changeIssueAssignee(username) {
    const formData = new FormData();
    formData.set('issueId', '' + this.selectedIssue.issueId);
    formData.set('username', '' + username);
    this.issueService.changeIssueAssignee(formData)
      .subscribe((issue: Issue) => {
        this.selectedIssue.assignedTo = issue.assignedTo;
      }, (error: any) => {
        console.error(error);
      });
  }

  changeIssueProject(projectId) {
    const formData = new FormData();
    formData.set('issueId', '' + this.selectedIssue.issueId);
    formData.set('projectId', '' + projectId);
    this.issueService.changeIssueProject(formData)
      .subscribe((issue: Issue) => {
        this.selectedIssue.project = issue.project;
      }, (error: any) => {
        console.error(error);
      });
  }
}
