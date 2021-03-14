import { Component, OnInit } from '@angular/core';
import { UserService } from '../../auth/service/user.service';
import { ActivatedRoute } from '@angular/router';
import { UserDto } from '../../modal/rest';
import { UpdateProfileComponent } from '../update-profile/update-profile.component';
import { MatDialog } from '@angular/material/dialog';
import { TokenStorageService } from '../../auth/service/storage.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  idUser: number;
  user: UserDto = {} as UserDto;

  constructor(private userService: UserService, private route: ActivatedRoute,
    private dialog: MatDialog, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.idUser = this.route.snapshot.params.idUser;
    this.userService.findUserById(this.idUser).subscribe((user) => {
      this.user = user;
    })

  }

  updateProfile(idUser: number) {
    this.dialog.open(UpdateProfileComponent, {
      autoFocus: false,
      disableClose: true,
      panelClass: 'auth-dialog-container',
      width: '300px',
      data: { idUser }
    });
  }
  logout() {
    this.tokenStorageService.signOut();
    window.location.replace('/home');
  }
}
