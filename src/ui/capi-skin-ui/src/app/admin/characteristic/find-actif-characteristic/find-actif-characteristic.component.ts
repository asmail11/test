import { Component, OnInit } from '@angular/core';
import { ActifDto } from '../../../modal/rest';
import { ActifService } from '../../../service/actif.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-find-actif-characteristic',
  templateUrl: './find-actif-characteristic.component.html',
  styleUrls: ['./find-actif-characteristic.component.scss']
})
export class FindActifCharacteristicComponent implements OnInit {
  actifDto: ActifDto = {} as ActifDto;
  idActif: number;

  constructor(private actifService: ActifService, private route: ActivatedRoute) {
    this.route.params.subscribe(
      params => {
        this.idActif = this.route.snapshot.params.idActif;
        this.actifService.findActif(this.idActif).subscribe((actifDto) => {
         this.actifDto = actifDto;
        })
      }
    )
   }

  ngOnInit(): void {
  }

}
