import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MaterialModule } from './material-module';
import { HttpClientModule } from '@angular/common/http';
import { SingupComponent } from '../auth/singup/singup.component';
import { SinginComponent } from '../auth/singin/singin.component';

@NgModule({
  declarations: [
    SinginComponent,
    SingupComponent,
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
export class AuthModule { }
