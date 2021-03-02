import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { AddActifComponent } from '../admin/actif/add-actif/add-actif.component';
import { FindActifComponent } from '../admin/actif/find-actif/find-actif.component';
import { DisplayActifComponent } from '../admin/actif/display-actif/display-actif.component';
import { AddBaseProductComponent } from '../admin/base-product/add-base-product/add-base-product.component';
import { DisplayBaseProductComponent } from '../admin/base-product/display-base-product/display-base-product.component';
import { FindBaseProductComponent } from '../admin/base-product/find-base-product/find-base-product.component';
import { AddCategoryComponent } from '../admin/category/add-category/add-category.component';
import { DisplayBodyAndHairComponent } from '../admin/body-and-hair/display-body-and-hair/display-body-and-hair.component';
import { FindBodyAndHairComponent } from '../admin/body-and-hair/find-body-and-hair/find-body-and-hair.component';
import { AddBodyAndHairComponent } from '../admin/body-and-hair/add-body-and-hair/add-body-and-hair.component';
import { FindCategoryComponent } from '../admin/category/find-category/find-category.component';
import { DisplayCategoryComponent } from '../admin/category/display-category/display-category.component';
import { FindCharacteristicComponent } from '../admin/characteristic/find-characteristic/find-characteristic.component';
import { AddCharacteristicComponent } from '../admin/characteristic/add-characteristic/add-characteristic.component';
import { DisplayCharacteristicComponent } from '../admin/characteristic/display-characteristic/display-characteristic.component';
import { AddCommanndComponent } from '../admin/command/add-commannd/add-commannd.component';
import { FindCommanndComponent } from '../admin/command/find-commannd/find-commannd.component';
import { AddEssentialOilComponent } from '../admin/essential-oil/add-essential-oil/add-essential-oil.component';
import { FindEssentialOilComponent } from '../admin/essential-oil/find-essential-oil/find-essential-oil.component';
import { DisplayEssentialOilComponent } from '../admin/essential-oil/display-essential-oil/display-essential-oil.component';
import { DisplayContentMillimiterComponent } from '../admin/contentMillimiter/display-content-millimiter/display-content-millimiter.component';
import { FindContentMillimiterComponent } from '../admin/contentMillimiter/find-content-millimiter/find-content-millimiter.component';
import { AddContentMillimiterComponent } from '../admin/contentMillimiter/add-content-millimiter/add-content-millimiter.component';
import { AddFaceAndCareComponent } from '../admin/face-and-care/add-face-and-care/add-face-and-care.component';
import { FindFaceAndCareComponent } from '../admin/face-and-care/find-face-and-care/find-face-and-care.component';
import { DisplayFaceAndCareComponent } from '../admin/face-and-care/display-face-and-care/display-face-and-care.component';
import { AddFianlProductComponent } from '../admin/final-product/add-fianl-product/add-fianl-product.component';
import { FindFianlProductComponent } from '../admin/final-product/find-fianl-product/find-fianl-product.component';
import { DisplayFianlProductComponent } from '../admin/final-product/display-fianl-product/display-fianl-product.component';
import { AddIngredientComponent } from '../admin/ingredient/add-ingredient/add-ingredient.component';
import { FindIngredientComponent } from '../admin/ingredient/find-ingredient/find-ingredient.component';
import { DisplayIngredientComponent } from '../admin/ingredient/display-ingredient/display-ingredient.component';
import { AddNeedsComponent } from '../admin/needs/add-needs/add-needs.component';
import { FindNeedsComponent } from '../admin/needs/find-needs/find-needs.component';
import { DisplayNeedsComponent } from '../admin/needs/display-needs/display-needs.component';
import { AddVegetableOilComponent } from '../admin/vegetable-oil/add-vegetable-oil/add-vegetable-oil.component';
import { FindVegetableOilComponent } from '../admin/vegetable-oil/find-vegetable-oil/find-vegetable-oil.component';
import { DisplayVegetableOilComponent } from '../admin/vegetable-oil/display-vegetable-oil/display-vegetable-oil.component';
import { DashboardComponent } from '../admin/dashboard/dashboard/dashboard.component';
import { AddIngredientProductComponent } from '../admin/ingredient-product/add-ingredient-product/add-ingredient-product.component';
import { FindIngredientProductComponent } from '../admin/ingredient-product/find-ingredient-product/find-ingredient-product.component';
import { DisplayIngredientProdutComponent } from '../admin/ingredient-product/display-ingredient-produt/display-ingredient-produt.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material-module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AddActifComponent,
    FindActifComponent,
    DisplayActifComponent,
    AddBaseProductComponent,
    FindBaseProductComponent,
    DisplayBaseProductComponent,
    AddBodyAndHairComponent,
    FindBodyAndHairComponent,
    DisplayBodyAndHairComponent,
    AddCategoryComponent,
    FindCategoryComponent,
    DisplayCategoryComponent,
    AddCharacteristicComponent,
    FindCharacteristicComponent,
    DisplayCharacteristicComponent,
    AddCommanndComponent,
    FindCommanndComponent,
    AddContentMillimiterComponent,
    FindContentMillimiterComponent,
    DisplayContentMillimiterComponent,
    AddEssentialOilComponent,
    FindEssentialOilComponent,
    DisplayEssentialOilComponent,
    AddFaceAndCareComponent,
    FindFaceAndCareComponent,
    DisplayFaceAndCareComponent,
    AddFianlProductComponent,
    FindFianlProductComponent,
    DisplayFianlProductComponent,
    AddIngredientComponent,
    FindIngredientComponent,
    DisplayIngredientComponent,
    AddNeedsComponent,
    FindNeedsComponent,
    DisplayNeedsComponent,
    AddVegetableOilComponent,
    FindVegetableOilComponent,
    DisplayVegetableOilComponent,
    AddIngredientProductComponent,
    FindIngredientProductComponent,
    DisplayIngredientProdutComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  exports: [
    MaterialModule
  ],
  entryComponents: [

  ],
  providers: [],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA ]
})
export class AdminModule { }
