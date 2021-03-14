import { NgModule } from '@angular/core';
import { Routes, RouterModule, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { HomeComponent } from '../layout/home/home.component';
import { UserProfileComponent } from '../user/user-profile/user-profile.component';
import { AddAccountComponent } from '../user/add-account/add-account.component';
import { AuthInterceptor } from '../auth/service/auth.interceptor';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent, data: {title: 'home'},
  },
  {
    path: 'user-profile/:idUser',
    component: UserProfileComponent, data: {title: 'user-profile'},
    canActivate: [AuthInterceptor],
    children: [
      {
        path: 'add-account',
        component: AddAccountComponent, data: {title: 'add-account'},
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
