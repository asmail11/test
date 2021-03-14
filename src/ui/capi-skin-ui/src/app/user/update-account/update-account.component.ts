import { Component, Inject, OnInit } from '@angular/core';
import { AccountDto, UserDto, PaymentDto } from '../../modal/rest';
import { AccountService } from '../service/account.service';
import { ActivatedRoute } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { delay } from 'rxjs/operators';
import { UserService } from '../../auth/service/user.service';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.scss']
})
export class UpdateAccountComponent implements OnInit {

  accountDto: AccountDto = {} as AccountDto;
  paymentDto: PaymentDto = {} as PaymentDto;

  gender: any;
  showSpinner = false;
  userDto: UserDto = {} as UserDto;

  validateConditionAccept = false;

  constructor(private accountService: AccountService, private route: ActivatedRoute, private dialog: MatDialog,
    private snackBar: MatSnackBar, @Inject(MAT_DIALOG_DATA) private data: any) {
    this.route.params.subscribe(
      params => {
        this.accountService.findAccountForUser(this.data.idUser).subscribe((accountDto) => {
          this.accountDto = accountDto;
          this.validateConditionAccept = true;
        })
      }
    )
  }

  ngOnInit(): void {


  }
  setGender(): void {
    if (this.accountDto != null) {
      this.accountDto.gender = this.accountDto.gender;
    } else {
      this.accountDto.gender = this.gender;
    }
  }

  toggleAcceptCondition(e) {
    if (e.checked) {
      this.accountDto.conditionAccept = "Accept condition";
      this.accountDto.conditionAccept = this.accountDto.conditionAccept;
      this.validateConditionAccept = true;
    } else {
      this.accountDto.conditionAccept = "Don't accept condition";
      this.accountDto.conditionAccept = null;
      this.validateConditionAccept = false;
    }
    
  }
  updateAccount(idAccount: number) {
    this.showSpinner = true;
    this.accountService.updateAccount(this.accountDto, idAccount).subscribe((accountDto) => {
      this.accountDto = accountDto;
      this.snackBar
        .open(
          ' Information updated with successfully.',
          'ok',
          { duration: 500, panelClass: ['mat-toolbar', 'mat-primary'] }
        )
        .afterDismissed()
        .pipe(delay(0))
        .subscribe(() => {

        });
    })
  }
}

