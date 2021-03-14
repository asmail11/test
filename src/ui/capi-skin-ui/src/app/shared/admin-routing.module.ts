import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import { DashboardComponent } from '../admin/dashboard/dashboard.component';
import { DisplayBodyFaceHairComponent } from '../admin/body-face-hair/display-body-face-hair/display-body-face-hair.component';
import { TreeApplicationComponent } from '../admin/tree-application/tree-application.component';
import { DisplayIngredientComponent } from '../admin/ingredient/display-ingredient/display-ingredient.component';
import { DisplayActifComponent } from '../admin/actif/display-actif/display-actif.component';
import { DisplayEssentialComponent } from '../admin/essential/display-essential/display-essential.component';
import { DisplayTypeComponent } from '../admin/types/display-type/display-type.component';
import { DisplayNeedComponent } from '../admin/needs/display-need/display-need.component';
import { DisplayBaseProductComponent } from '../admin/base-product/display-base-product/display-base-product.component';
import { DisplayCharacteristicComponent } from '../admin/characteristic/display-characteristic/display-characteristic.component';
import { DetailsIngredeintCharacteristicComponent } from '../admin/characteristic/details-ingredeint-characteristic/details-ingredeint-characteristic.component';
import { FindIngredientCharacteristicComponent } from '../admin/characteristic/find-ingredient-characteristic/find-ingredient-characteristic.component';
import { FindActifCharacteristicComponent } from '../admin/characteristic/find-actif-characteristic/find-actif-characteristic.component';
import { FindEssentialCharacteristicComponent } from '../admin/characteristic/find-essential-characteristic/find-essential-characteristic.component';
import { NotFoundComponent } from '../layout/not-found/not-found.component';
import { AdminProfileComponent } from '../admin/admin-profile/admin-profile.component';
import { AuthInterceptor } from '../auth/service/auth.interceptor';

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  {
    path: 'dashboard',
    component: DashboardComponent, data: {title: 'dashboard'},
    canActivate: [AuthInterceptor],
    children: [
      {
        path: 'display-actifs',
        component: DisplayActifComponent, data: {title: 'display-actifs'},
      },
      {
        path: 'display-essential',
        component: DisplayEssentialComponent, data: {title: 'display-essential'},
      },
      {
        path: 'display-ingredient',
        component: DisplayIngredientComponent, data: {title: 'display-ingredient'},
      }
    ]
  },
   {
    path: 'tree-application/:idBody',
    component: TreeApplicationComponent, data: {title: 'tree-application'},
    canActivate: [AuthInterceptor],
    children: [
      {
        path: '',
        component: DisplayBodyFaceHairComponent
      },
      {
        path: 'find-body-and-hair/:idBody',
        component: DisplayBodyFaceHairComponent, data: {title: 'find-body-and-hair'},
      },
      {
        path: 'display-ingredients',
        component: DisplayIngredientComponent, data: {title: 'display-ingredients'},
      },
      {
        path: 'display-actifs',
        component: DisplayActifComponent, data: {title: 'display-actifs'},
      },
      {
        path: 'display-essentials',
        component: DisplayEssentialComponent, data: {title: 'display-essentials'},
      },
      {
        path: 'display-body-face-hair/:idBody',
        component: DisplayBodyFaceHairComponent, data: {title: 'display-body-face-hair'},
      },
      {
        path: 'display-type/:idType',
        component: DisplayTypeComponent, data: {title: 'display-type'},
      },
     {
       path: 'display-characteristic/:idCharacteristic',
        component: DisplayCharacteristicComponent, data: {title: 'display-characteristic'},
        children: [
          {
            path: 'details-ingredeint-characteristic/:idCharacteristic',
            component: DetailsIngredeintCharacteristicComponent, data: {title: 'details-ingredeint-characteristic'},
          }
        ]
     },
     {
       path: 'display-need/:idNeed',
       component: DisplayNeedComponent, data: {title: 'display-need'},
     },
     {
       path: 'display-base-product/:idBase',
       component: DisplayBaseProductComponent, data: {title: 'display-base-product'},
     },
     {
       path: 'find-ingredient-characteristic/:idIngredient',
       component: FindIngredientCharacteristicComponent, data: {title: 'find-ingredient-characteristic'},
     },
     {
       path: 'find-actif-characteristic/:idActif',
       component: FindActifCharacteristicComponent, data: {title: 'find-actif-characteristic'},
     },
     {
       path: 'find-essential-characteristic/:idEssentail',
       component: FindEssentialCharacteristicComponent, data: {title: 'find-essential-characteristic'},
     }
    ]
   },
   {
     path: 'admin-profile',
     component:     AdminProfileComponent, data: {title: 'admin-profile'},
     canActivate: [AuthInterceptor],
   },
   {path: '404', component: NotFoundComponent, data: {title: 'Capi skin 404 Error page not found'},},
   {path: '**', redirectTo: '/404'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
