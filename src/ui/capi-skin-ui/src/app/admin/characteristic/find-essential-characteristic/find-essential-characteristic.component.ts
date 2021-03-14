import { Component, OnInit } from '@angular/core';
import { EssentialOilService } from '../../../service/essential-oil.service';
import { EssentialOilDto } from 'src/app/modal/rest';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-find-essential-characteristic',
  templateUrl: './find-essential-characteristic.component.html',
  styleUrls: ['./find-essential-characteristic.component.scss']
})
export class FindEssentialCharacteristicComponent implements OnInit {
essentialOilDto: EssentialOilDto = {} as EssentialOilDto;
idEssentail: number;

  constructor(private essentialOilService: EssentialOilService, private route: ActivatedRoute) {
    this.route.params.subscribe(
      params => {
        this.idEssentail = this.route.snapshot.params.idEssentail;
        this.essentialOilService.findEssentialOil(this.idEssentail).subscribe((essentialOilDto) => {
         this.essentialOilDto = essentialOilDto;
        })
      }
    )
   }

  ngOnInit(): void {
  }

}
