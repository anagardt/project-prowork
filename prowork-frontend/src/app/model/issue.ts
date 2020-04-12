import {User} from "./user";
import {Project} from "./project";

export class Issue {
  issueId: number;
  name: string;
  status: string;
  type: string;
  project: Project;
  createdBy: User;
  reviewedBy: User;
  assignedTo: User;
  dateCreated: Date;
  dateDue: Date;
  description: string;
}
