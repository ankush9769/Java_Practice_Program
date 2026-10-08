import { Routes } from '@angular/router';
import { Pagenotfound } from './pagenotfound/pagenotfound';
import { First } from './first/first';
import { Second } from './second/second';

export const routes: Routes = [
    {path:'',redirectTo:'/home',pathMatch:'full'},
    {path:'home',component:First},
    {path:'about',component:Second},
    {path:'**',component:Pagenotfound}
];
