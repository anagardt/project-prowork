// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  restApiUrl: 'http://localhost:8080/api',
  accessController: {
    url: '/access',
    login: '/login',
    register: '/register',
    reset: '/passwordReset',
    resetSave: '/passwordResetSave'
  },
  issueController: {
    url: '/issue',
    newIssue: '/new',
    changeProject: '/changeProject',
    changeStatus: '/changeStatus',
    changeAssignee: '/changeAssignee',
    allIssues: '/all',
    created: '/created',
    reviewed: '/reviewed',
    assigned: '/assigned'
  },
  userController: {
    url: '/user',
    getAll: '/getAll'
  },
  projectController: {
    url: '/project',
    getAll: '/getAll',
    newProject: '/new'
  },
  commentController: {
    url: '/comment',

    allByIssueId: '/allByIssueId',
    addComment: '/new',
    deleteComment: '/delete'
  }
};
