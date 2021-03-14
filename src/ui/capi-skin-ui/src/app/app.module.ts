import { BrowserModule, Title } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA , NO_ERRORS_SCHEMA } from '@angular/core';
import { AuthModule } from './shared/auth.module';
import { AppRoutingModule } from './shared/app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminRoutingModule } from './shared/admin-routing.module';
import { AdminModule } from './shared/admin.module';
import { DeleteDialogComponent } from './confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { AlertComponent } from './confirmation-dialog-model/alert/alert.component';
import { HomeComponent } from './layout/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { NotFoundComponent } from './layout/not-found/not-found.component';
import { NavBarComponent } from './layout/nav-bar/nav-bar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { UserModule } from './shared/user.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgxPaginationModule } from 'ngx-pagination';
import { MaterialModule } from './shared/material-module';
import { UpdateProfileComponent } from './user/update-profile/update-profile.component';
import { AuthInterceptor } from './auth/service/auth.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    DeleteDialogComponent,
    AlertComponent,
    HomeComponent,
    NotFoundComponent,
    NavBarComponent,
    FooterComponent,
    UpdateProfileComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AdminRoutingModule,
    BrowserAnimationsModule,
    AdminModule,
    AuthModule,
    UserModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MaterialModule,
    NgxPaginationModule,
  

  ],
  providers: [Title, AuthInterceptor],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA ],
  exports: [AdminModule, AuthModule, UserModule]
})
export class AppModule { }
