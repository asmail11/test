import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AuthService } from 'src/app/auth/service/auth.service';
import { UserModule } from '../../shared/user.module';
import { UserDto } from '../../modal/rest';
import { UserService } from '../../auth/service/user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.scss']
})
export class UpdateProfileComponent implements OnInit {
  userDto: UserDto = {} as UserDto;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  showSpinner = false;

  constructor(private userService: UserService,  public matDialogRef: MatDialogRef<UpdateProfileComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.userService.findUserById(this.data.idUser).subscribe((userDto) => {
      this.userDto = userDto;
    })
  }

  onSubmit(): void {
    this.showSpinner = true;
    this.userService.updateUser(this.userDto, this.data.idUser).subscribe(
      data => {
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.showSpinner = false;
        this.snackBar
        .open(
           'Account updated with successfully.',
          'ok',
          { duration: 1000, panelClass: ['mat-toolbar', 'mat-primary'] }
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
        this.isSignUpFailed = true;
      }
    );
  }


}
