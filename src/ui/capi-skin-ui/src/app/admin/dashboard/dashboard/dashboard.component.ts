import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AddCategoryComponent } from '../../category/add-category/add-category.component';
import { StorageService } from '../../../auth/service/storage.service';
import { UserService } from '../../../auth/service/user.service';
import { SignUpFormDto } from '../../../modal/rest';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
   username: string;
   signUpFormDto: SignUpFormDto = {} as SignUpFormDto;

  constructor(private dialog: MatDialog, private storageService: StorageService,
    private userService: UserService) { }

  ngOnInit(): void {
    this.username = this.storageService.getUsername();
    this.userService.getUserByUsername(this.username).subscribe((signUpFormDto) => {
      this.signUpFormDto = signUpFormDto;
      console.log(this.signUpFormDto)
    })
  }
  addCategory(idUser: number) {
    this.dialog.open(AddCategoryComponent, {
      data: {idUser},
      height: '320px',
      width: '400px',
    });
  }
}
