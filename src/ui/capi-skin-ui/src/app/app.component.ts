import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SignupComponent } from './auth/signup/signup.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private dialog: MatDialog) {

  }

  title = 'capi-skin-ui';
  idUser = 1;

  register() {
    this.dialog.open(SignupComponent, {
      height: '650px',
      width: '500px',
    });
  }
}
