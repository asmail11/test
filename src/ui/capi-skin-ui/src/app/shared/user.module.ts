import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MaterialModule } from './material-module';
import { HttpClientModule } from '@angular/common/http';
import { UpdateAccountComponent } from '../user/update-account/update-account.component';
import { UpdatePaymentComponent } from '../user/update-payment/update-payment.component';
import { AddAccountComponent } from '../user/add-account/add-account.component';
import { CryptogrammeInfoComponent } from '../user/cryptogramme-info/cryptogramme-info.component';
import { UserProfileComponent } from '../user/user-profile/user-profile.component';

@NgModule({
  declarations: [
    UpdateAccountComponent,
    UpdatePaymentComponent,
    UserProfileComponent,
    AddAccountComponent,
    CryptogrammeInfoComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MaterialModule,
    HttpClientModule
  ],
  entryComponents: [

  ],
  providers: [],
  bootstrap: [],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA ],
  exports: [MaterialModule]
})
export class UserModule { }
