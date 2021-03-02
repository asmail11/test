import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { LoginInfo } from '../modal/LoginInfo';
import { AuthService } from '../service/auth.service';
import { StorageService } from '../service/storage.service';
import { SignupComponent } from '../signup/signup.component';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  loginInfo: LoginInfo;
  showSpinner = false;

  constructor(private authService: AuthService, private router: Router,
  private tokenStorageService: StorageService, private dialog: MatDialog,
  public dialogRef: MatDialogRef<SigninComponent>) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
      this.showSpinner = true;
      this.loginInfo =  new LoginInfo(
      this.form.username,
      this.form.password
    );

      this.authService.login(this.loginInfo).subscribe(data => {
      this.tokenStorageService.saveToken(data.accessToken);
      this.tokenStorageService.saveUsername(data.username);
      this.tokenStorageService.saveAuthorities(data.authorities);

      this.isLoggedIn = true;
      this.isLoginFailed = false;
      this.router.navigate(['/home']);


      this.dialogRef.close();
    }, error => {
      this.isLoginFailed = true;
      this.showSpinner = false;
    });
  }
  signup() {
    this.dialog.open(SignupComponent, {
      height: '650px',
      width: '500px',
    });
  }
}

