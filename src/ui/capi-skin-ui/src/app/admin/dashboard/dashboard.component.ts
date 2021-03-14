import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BodyFaceHairDto, UserDto } from '../../modal/rest';
import { AddActifComponent } from '../actif/add-actif/add-actif.component';
import { AddIngredientComponent } from '../ingredient/add-ingredient/add-ingredient.component';
import { AddEssentialComponent } from '../essential/add-essential/add-essential.component';
import { AddBodyFaceHairComponent } from '../body-face-hair/add-body-face-hair/add-body-face-hair.component';
import { BodyFaceHairService } from '../../service/body-face-hair.service';
import { delay } from 'rxjs/operators';
import { ConfirmDialogModel } from 'src/app/confirmation-dialog-model/ConfirmDialogModel';
import { DeleteDialogComponent } from 'src/app/confirmation-dialog-model/delete-dialog/delete-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActifService } from '../../service/actif.service';
import { EssentialOilService } from '../../service/essential-oil.service';
import { IngredientService } from 'src/app/service/ingredient.service';
import { SingupComponent } from 'src/app/auth/singup/singup.component';
import { UserService } from '../../auth/service/user.service';
import { SinginComponent } from 'src/app/auth/singin/singin.component';
import { TokenStorageService } from '../../auth/service/storage.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  bodyFaceHairs: BodyFaceHairDto[];
  user: UserDto = {} as UserDto;
  categoriesLength = 0;
  actifsLength = 0;
  essentailLength = 0;
  ingredientsLength = 0;
  progressBar = true;
  username: string;
  roles: string[];
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;

  constructor(private dialog: MatDialog, private bodyFaceHairService: BodyFaceHairService,
    private snackBar: MatSnackBar, private actifService: ActifService, private tokenStorageService: TokenStorageService,
    private essentialOilService: EssentialOilService, private ingredientService: IngredientService,
    private userService: UserService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');

      this.username = user.username;
    }
    this.bodyFaceHairService.findBodyFaceHairs().subscribe((bodyFaceHairs) => {
      this.bodyFaceHairs = bodyFaceHairs;
      this.categoriesLength = bodyFaceHairs.length;
    })
    this.actifService.finActifs().subscribe((actifs) => {
     this.actifsLength = actifs.length;
    })
    this.essentialOilService.findEssentialOils().subscribe((essentials) => {
      this.essentailLength = essentials.length;
    })
    this.ingredientService.findIngredients().subscribe((ingredients) => {
      this.ingredientsLength = ingredients.length;
    })
  }
  addBodyFaceHaire(idUser: number) {
    const dialogRef = this.dialog.open(AddBodyFaceHairComponent, {
      disableClose: true,
      autoFocus: false,
      panelClass: 'add-dialog-container',
      data: {idUser}
    });
  }
  addActif(idUser: number) {
    const dialogRef = this.dialog.open(AddActifComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: {idUser}
    });
  }
  addEssential(idUser: number) {
    const dialogRef = this.dialog.open(AddEssentialComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: {idUser}
    });
  }
  addIngredent(idUser: number) {
    const dialogRef = this.dialog.open(AddIngredientComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data: {idUser}
    });

  }
  deleteBodyFaceHaire(id) {
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
        this.bodyFaceHairService.deleteBodyFaceHair(id).subscribe(() => {
          this.progressBar = false;
          this.snackBar
            .open('Category deleted with successfully.', 'ok',
              {
                duration: 1500,
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
  editBodyFaceHaire(idBody) {
    const dialogRef = this.dialog.open(AddBodyFaceHairComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'add-dialog-container',
      data:  {idBody}
    });
  }
  signup() {
    this.dialog.open(SingupComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'auth-dialog-container',
    });
  }
  singin() {
    this.dialog.open(SinginComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'auth-dialog-container',
    });
  }
}
