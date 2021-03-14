import { Component, OnInit } from '@angular/core';
import { SingUp } from '../modal/Singup';
import { Singin } from '../modal/Singin';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { TokenStorageService } from '../service/storage.service';
import { SinginComponent } from '../singin/singin.component';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.scss']
})
export class SingupComponent implements OnInit {
  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  showSpinner = false;
  singup: SingUp;
  showExistName = false;

  constructor(private authService: AuthService, private dialog: MatDialog,
    private userService: UserService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.showSpinner = true;
  //  this.form.role = ['admin']
    this.userService.existsByUsername(this.form.username).subscribe((data) => {
      if (data == false) {
        this.singup = new SingUp(
          this.form.username,
          this.form.emain,
          this.form.password
        )
        this.authService.signup(this.form).subscribe(
          data => {
            console.log(data);
            this.isSuccessful = true;
            this.isSignUpFailed = false;
            this.showSpinner = false;
            console.log(data);
            
          },
          err => {
            this.errorMessage = err.error.message;
            this.isSignUpFailed = true;
          });
      } else {
        this.showExistName = true;
      }

    })
  }

  usernameCorrect() {
    this.showExistName = false;
  }

  singin() {
    this.dialog.open(SinginComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'auth-dialog-container',
    });
  }

}
