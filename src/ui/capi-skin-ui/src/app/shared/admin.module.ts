import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MaterialModule } from './material-module';
import { DashboardComponent } from '../admin/dashboard/dashboard.component';
import { AddIngredientComponent } from '../admin/ingredient/add-ingredient/add-ingredient.component';
import { HttpClientModule } from '@angular/common/http';
import { DisplayIngredientComponent } from '../admin/ingredient/display-ingredient/display-ingredient.component';
import { AddActifComponent } from '../admin/actif/add-actif/add-actif.component';
import { DisplayActifComponent } from '../admin/actif/display-actif/display-actif.component';
import { AddEssentialComponent } from '../admin/essential/add-essential/add-essential.component';
import { DisplayEssentialComponent } from '../admin/essential/display-essential/display-essential.component';
import { AddBodyFaceHairComponent } from '../admin/body-face-hair/add-body-face-hair/add-body-face-hair.component';
import { DisplayBodyFaceHairComponent } from '../admin/body-face-hair/display-body-face-hair/display-body-face-hair.component';
import { TreeApplicationComponent } from '../admin/tree-application/tree-application.component';
import { DetailsIngredientComponent } from '../admin/ingredient/details-ingredient/details-ingredient.component';
import { DetailsActifComponent } from '../admin/actif/details-actif/details-actif.component';
import { DetailsEssentialComponent } from '../admin/essential/details-essential/details-essential.component';
import { AddTypeComponent } from '../admin/types/add-type/add-type.component';
import { DisplayTypeComponent } from '../admin/types/display-type/display-type.component';
import { AddNeedComponent } from '../admin/needs/add-need/add-need.component';
import { DisplayNeedComponent } from '../admin/needs/display-need/display-need.component';
import { DisplayBaseProductComponent } from '../admin/base-product/display-base-product/display-base-product.component';
import { AddBaseProductComponent } from '../admin/base-product/add-base-product/add-base-product.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { AddActifCharacteristicComponent } from '../admin/characteristic/add-actif-characteristic/add-actif-characteristic.component';
import { AddEssentialCharacteristicComponent } from '../admin/characteristic/add-essential-characteristic/add-essential-characteristic.component';
import { AddIngredeintCharacteristicComponent } from '../admin/characteristic/add-ingredeint-characteristic/add-ingredeint-characteristic.component';
import { DisplayCharacteristicComponent } from '../admin/characteristic/display-characteristic/display-characteristic.component';
import { AddCharacteristicComponent } from '../admin/characteristic/add-characteristic/add-characteristic.component';
import { DetailsIngredeintCharacteristicComponent } from '../admin/characteristic/details-ingredeint-characteristic/details-ingredeint-characteristic.component';
import { FindActifCharacteristicComponent } from '../admin/characteristic/find-actif-characteristic/find-actif-characteristic.component';
import { FindEssentialCharacteristicComponent } from '../admin/characteristic/find-essential-characteristic/find-essential-characteristic.component';
import { FindIngredientCharacteristicComponent } from '../admin/characteristic/find-ingredient-characteristic/find-ingredient-characteristic.component';
import { AdminProfileComponent } from '../admin/admin-profile/admin-profile.component';

@NgModule({
  declarations: [
    DashboardComponent,
    AddIngredientComponent,
    DisplayIngredientComponent,
    AddActifComponent,
    DisplayActifComponent,
    AddEssentialComponent,
    DisplayEssentialComponent,
    AddBodyFaceHairComponent,
    DisplayBodyFaceHairComponent,
    TreeApplicationComponent,
    DetailsIngredientComponent,
    DetailsActifComponent,
    DetailsEssentialComponent,
    AddTypeComponent,
    DisplayTypeComponent,
    DisplayCharacteristicComponent,
    AddNeedComponent,
    DisplayNeedComponent,
    AddBaseProductComponent,
    DisplayBaseProductComponent,
    AddActifCharacteristicComponent,
    AddEssentialCharacteristicComponent,
    AddIngredeintCharacteristicComponent,
    AddCharacteristicComponent,
    DetailsIngredeintCharacteristicComponent,
    FindIngredientCharacteristicComponent,
    FindEssentialCharacteristicComponent,
    FindActifCharacteristicComponent,
    AdminProfileComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MaterialModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  entryComponents: [

  ],
  providers: [],
  bootstrap: [],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA ],
  exports: [MaterialModule]
})
export class AdminModule { }
