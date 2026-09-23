import { Routes } from '@angular/router';
import { Home } from './page/home/home';
import { Login } from './page/login/login';
import { Dashboard } from './page/dashboard/dashboard';
import { EditProfile } from './page/edit-profile/edit-profile';
import { dashoardGuard } from './guards/dashoard-guard';
import { editProfileGuard } from './guards/edit-profile-guard';
import { adminGaurdGuard } from './guards/admin-gaurd-guard';

export const routes: Routes = [
    {path:'', component:Home},
    {path:'login',component:Login},
    {path:'dashboard',component:Dashboard,canActivate:[dashoardGuard]},
    {path:'editprofile',component:EditProfile,canDeactivate:[editProfileGuard],canActivate:[dashoardGuard]},
    {path:'admin',canMatch:[adminGaurdGuard],loadComponent:()=>import('./page/admin/admin').then((m)=>m.Admin)}
];
