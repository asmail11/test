import { Component, OnInit } from '@angular/core';
import { SingupComponent } from '../singup/singup.component';
import { AuthService } from '../service/auth.service';
import { TokenStorageService } from '../service/storage.service';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { UserDto } from '../../modal/rest';
import { Singin } from '../modal/Singin';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-singin',
  templateUrl: './singin.component.html',
  styleUrls: ['./singin.component.scss']
})
export class SinginComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  showSpinner=false;
  singin: Singin;

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, 
    private dialog: MatDialog, public matDialogRef: MatDialogRef<SinginComponent>,
     private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
    
  }

  onSubmit(): void {
    this.singin = new Singin(
      this.form.username,
      this.form.password
    )

    this.authService.signin(this.singin).subscribe((data) => {
       this.singin = data;
       this.tokenStorage.saveToken(data.token);
        this.tokenStorage.saveUser(data);
         
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.snackBar
        .open(
           'You are signin with successfully.',
          'ok',
          { duration: 500, panelClass: ['mat-auth-container', 'mat-primary'] }
        )
        .afterDismissed()
        .pipe(delay(0))
        .subscribe(() => {
          window.location.reload();
        });
      this.matDialogRef.close();

      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  hasError() {
    this.isLoginFailed = false;
  }
  signup() {
    this.dialog.open(SingupComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'auth-dialog-container',
    });
  }

}
