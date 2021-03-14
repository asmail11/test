import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NumberValueAccessor } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatStepper } from '@angular/material/stepper';
import { ActivatedRoute } from '@angular/router';
import { delay } from 'rxjs/operators';
import { UserService } from 'src/app/auth/service/user.service';
import { AccountDto, PaymentDto, UserDto } from 'src/app/modal/rest';
import { AccountService } from '../service/account.service';
import { PaymentService } from '../service/payment.service';
import { UpdatePaymentComponent } from '../update-payment/update-payment.component';
import { UpdateAccountComponent } from '../update-account/update-account.component';
import { CryptogrammeInfoComponent } from '../cryptogramme-info/cryptogramme-info.component';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';

@Component({
  selector: 'app-add-account',
  templateUrl: './add-account.component.html',
  styleUrls: ['./add-account.component.scss']
})
export class AddAccountComponent implements OnInit {
  isLinear = false;
  isEditable = false;
  checked = false;
  indeterminate = false;
  labelPosition: 'before' | 'after' = 'after';
  disabled = false;
  accountDto: AccountDto = {} as AccountDto;
  accountValue: AccountDto = {} as AccountDto;
  paymentDto: PaymentDto = {} as PaymentDto;
  paymentValue: PaymentDto = {} as PaymentDto;
  accountFormGroup: FormGroup;
  paymentFormGroup: FormGroup;
  gender: any;
  showSpinner=false;
  validateConditionAccept = false;
  idUser: number;

  @ViewChild('stepper') stepper: MatStepper;
  completed = false;
  cartNumber: any;
  userDto: UserDto = {} as UserDto;
  
  isChecked = false;
  isAddPaymentFailed = false;
  progressBar = false;
  
  constructor(private accountService: AccountService, private route: ActivatedRoute, private dialog: MatDialog,
    private snackBar: MatSnackBar, private formBuilder: FormBuilder, private userService: UserService,
    private paymentService: PaymentService) { 
      this.route.params.subscribe(
        params => {
          this.idUser = this.route.parent.snapshot.params.idUser;
          this.userService.findUserById(this.idUser).subscribe((userDto) => {
           this.userDto = userDto;
    
             if(this.accountValue !== null && this.accountValue !== undefined) {
             
              this.accountService.findAccountForUser(userDto.id).subscribe((accountValue) => {
              
                    this.accountValue = accountValue;   
                           
                    this.accountFormGroup = this.formBuilder.group({
                      firstCtrl: ["", !Validators.required]
                    });
                    this.paymentFormGroup = this.formBuilder.group({
                      secondCtrl: ['', !Validators.required]
                    });               
              }) 
             }

             if(this.paymentValue!==null && this.paymentValue !== undefined) {
              this.paymentService.findPaymentForUser(userDto.id).subscribe((paymentValue) => {

                  this.paymentValue = paymentValue;

                  this.cartNumber = String(this.paymentValue.cartNumber);
                  this.cartNumber = this.cartNumber.replace(/\d(?=\d{3})/g, "*"); 
  
                  this.accountFormGroup = this.formBuilder.group({
                    firstCtrl: ["", !Validators.required]
                  });
                  this.paymentFormGroup = this.formBuilder.group({
                    secondCtrl: ['', !Validators.required]
                  });
      
              })
             }     
          })
        }
      )
    }

  ngOnInit(): void {
    this.accountFormGroup = this.formBuilder.group({
      firstCtrl: ['', Validators.required]
    });
    this.paymentFormGroup = this.formBuilder.group({
      secondCtrl: ['', Validators.required]
    });

  }
  setGender(): void {
   if(this.accountDto!=null) {
    this.accountDto.gender = this.accountDto.gender;
   } else{
    this.accountDto.gender = this.gender;
   }   
  }
  matStepperNext() {
    this.stepper.selected.completed = true;
    this.completed = true;
    this.stepper.next();
    if(this.accountDto!=null) {
      this.accountService.findAccountForUser(this.idUser).subscribe((accountValue) => {
        this.accountValue = accountValue;   
      }) 
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
  addAccount(idUser: number) {
    this.showSpinner = true;
      this.accountService.addAccount(this.accountDto, idUser).subscribe((accountDto) => {
        this.accountDto = accountDto;
        this.snackBar
        .open(
         ' Information saved with successfully.',
          'ok',
          { duration: 500, panelClass: ['mat-toolbar', 'mat-primary'] }
        )
        .afterDismissed()
        .pipe(delay(0))
        .subscribe(() => {
         this.matStepperNext();
        });
      })
  }
  addPayment(idUser: number) {
    this.showSpinner = true;
    this.paymentService.validatedCreditCardNumber(this.paymentDto.cartNumber).subscribe((data) => {
     if(data==true) {
 
       this.paymentService.addPayment(this.paymentDto, idUser).subscribe((paymentDto) => {
         this.paymentDto = paymentDto;
         this.snackBar
         .open(
          ' Information saved with successfully.',
           'ok',
           { duration: 500, panelClass: ['mat-toolbar', 'mat-primary'] }
         )
         .afterDismissed()
         .pipe(delay(0))
         .subscribe(() => {
           window.location.reload();
         });
        }) 
      }
      else {
        this.isAddPaymentFailed = true;
       }                 
    })    
  }

  cryptogrammeInfo() {
    this.dialog.open(CryptogrammeInfoComponent, {
      panelClass: 'auth-dialog-container',
      width: '500px',
      height: '400px'
    });
  }
  updateAccount(idUser: number) {
    this.dialog.open(UpdateAccountComponent, {
      panelClass: 'auth-dialog-container',
      height: '400px',
      data: {idUser},
      autoFocus: false,
      disableClose: true,
    });
  }
  updatePayment(idUser: number) {
    this.dialog.open(UpdatePaymentComponent, {
      panelClass: 'auth-dialog-container',
      height: '500px',
      width: '520px',
      data: {idUser},
      autoFocus: false,
      disableClose: true,
    });
  }
  deleteAccount(idUser: number, idAccount: number) {
    const message = `Are you sure you want to delete this category ?`;
    const dialogData = new ConfirmDialogModel('Confirm deleting', message);
    const dialogRef = this.dialog.open(DeleteDialogComponent, {
      maxWidth: '420px',
      data: dialogData,
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(dialogResult => {
      if (dialogResult) {
        this.progressBar = true;
        this.accountService.deleteAccount(idUser, idAccount).subscribe(() => {
          this.progressBar = false;
          this.snackBar
            .open('Account deleted with successfully.', 'ok',
              {
                duration: 1000,
                panelClass: ['mat-toolbar', 'mat-primary']
              })
            .afterDismissed()
            .pipe(delay(0))
            .subscribe(() => {
              window.location.reload();
            })
        });
      }
    });
  }

  deletePayment(idUser: number, idPayment: number) {
    const message = `Are you sure you want to delete this category ?`;
    const dialogData = new ConfirmDialogModel('Confirm deleting', message);
    const dialogRef = this.dialog.open(DeleteDialogComponent, {
      maxWidth: '420px',
      data: dialogData,
      disableClose: true
    });
    dialogRef.afterClosed().subscribe(dialogResult => {
      if (dialogResult) {
        this.progressBar = true;
        this.paymentService.deletePayment(idUser, idPayment).subscribe(() => {
          this.progressBar = false;
          this.snackBar
            .open('Payment deleted with successfully.', 'ok',
              {
                duration: 1000,
                panelClass: ['mat-toolbar', 'mat-primary']
              })
            .afterDismissed()
            .pipe(delay(0))
            .subscribe(() => {
              window.location.reload();
            })
        });
      }
    });
  }
}
