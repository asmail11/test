import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { StorageService } from '../service/storage.service';
import { Router } from '@angular/router';
import { RegisterInfo } from '../modal/RegisterInfo';
import { LoginInfo } from '../modal/LoginInfo';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { SigninComponent } from '../signin/signin.component';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  form: any = {};
  isSignedUp = false;
  signUpInfo: RegisterInfo;
  showSpinner = false;
  isSignUpFailed = false;
  errorMessage = false;
  gender: any = {};
  roles: string[] = [];
  loginInfo: any;
  profileInfo: RegisterInfo[];

  constructor(private authService: AuthService, private router: Router,
    private tokenStorageService: StorageService, private dialog: MatDialog,
    public dialogRef: MatDialogRef<SignupComponent>) {}

  ngOnInit(): void {
    this.gender = 'female';
  }
  setGender(): void {
   this.form.gender = this.gender;
  }

  onSubmit(): void {
      this.showSpinner = true;
      this.signUpInfo = new RegisterInfo (
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password,
      this.form.gender,
      this.form.birthDate,
      this.form.createdAt,
    );

    this.signUpInfo.role = ['admin'];
    this.authService.signup(this.signUpInfo).subscribe(signUpInfo => {
    this.signUpInfo = signUpInfo;

      this.loginInfo = new LoginInfo(
      this.form.username,
      this.form.password
      );

        this.authService.login(this.loginInfo).subscribe(loginInfo => {
        this.tokenStorageService.saveToken(loginInfo.accessToken);
        this.tokenStorageService.saveUsername(loginInfo.username);
        this.tokenStorageService.saveAuthorities(loginInfo.authorities);
        this.roles = this.tokenStorageService.getAuthorities();
        this.isSignedUp = true;
        this.showSpinner = false;
        this.isSignedUp = true;
        this.isSignUpFailed = false;
        this.router.navigate(['/home']);
        this.dialogRef.close();
      });
    }, error => {
      this.errorMessage = error.error.message;
      this.isSignUpFailed = true;
    });
  }


  login() {
    this.dialog.open(SigninComponent, {
      height: '450px',
      width: '500px',
    });
  }
}
