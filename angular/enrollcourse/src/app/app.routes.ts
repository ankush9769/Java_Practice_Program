import { Routes } from '@angular/router';
import path from 'node:path';
import { Login } from './page/login/login';
import { Courses } from './page/courses/courses';
import { EditProfile } from './page/edit-profile/edit-profile';
import { coursesGuard } from './guards/courses-guard';
import { editProfileGuard } from './guards/edit-profile-guard';

export const routes: Routes = [
    {path:'',component:Login},
    {path:'courses',component:Courses,canActivate:[coursesGuard]},
    {path:'admin-courses',canActivate:[coursesGuard],loadComponent:()=>import('./page/admin-courses/admin-courses').then((m)=>m.AdminCourses)},
    {path:'edit-profile',component:EditProfile,canActivate:[coursesGuard],canDeactivate:[editProfileGuard]},
    {path:'**',loadComponent:()=>import('./page/error/error').then((m)=>m.Error)},
];
