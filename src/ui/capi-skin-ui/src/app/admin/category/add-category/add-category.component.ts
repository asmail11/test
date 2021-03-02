import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { CategoryDto } from '../../../modal/rest';
import { CategoryService } from '../../../service/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.scss']
})
export class AddCategoryComponent implements OnInit {
  progressBar = false;
  category: CategoryDto = {} as CategoryDto;

  constructor(@Inject(MAT_DIALOG_DATA) private data: any, private categoryService: CategoryService) { }

  ngOnInit(): void {
    if(this.data.idCategory!=null) {
      this.categoryService.findCategory(this.data.idCategory).subscribe((category) => {
        this.category = category;
      })
    }
  }
  addCategory() {
    this.progressBar = true;
    if(this.data.idCategory!=null) {
      this.categoryService.editCategory(this.category, this.data.idCategory).subscribe((category) => {
        this.category = category;
        window.location.reload();
      })
    } else {
        this.categoryService.addCategory(this.category, this.data.idUser).subscribe((category) => {
          this.category = category;
          window.location.reload();
        })
    }
  }
}
