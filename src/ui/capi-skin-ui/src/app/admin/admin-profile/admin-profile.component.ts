import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../../auth/service/storage.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.scss']
})
export class AdminProfileComponent implements OnInit {

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
  }
  logout() {
    this.tokenStorageService.signOut();
    window.location.replace('/home');
  }
}
