import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { BodyFaceHairDto } from '../modal/rest';
import { BodyFaceHairService } from './body-face-hair.service';

export class NodeAction {
  linkActive: string;
  url: string;
  title: string;
}
export class ApplicationItemNode {
  children: ApplicationItemNode[] = [];
  name: string;
  id: number;
  clazz: string;
  actions: NodeAction[] = [];
  title: string;
  routerLink: any;
}
export class ApplicationItemFlatNode {
  id: number;
  item: string;
  clazz: string;
  level: number;
  name: string;
  expandable: boolean;
  actions: NodeAction[] = [];
  title: string;
  routerLink: any;
}


@Injectable({
  providedIn: 'root'
})
export class TreeApplicationService {
  idBody: number;
  applicationData = new BehaviorSubject<ApplicationItemNode[]>([]);
  applicationState = new BehaviorSubject<BodyFaceHairDto>({} as BodyFaceHairDto);

  constructor(private route: ActivatedRoute, private bodyFaceHairService: BodyFaceHairService) {
    this.initialize();
  }


  initialize() {
    this.idBody = this.route.snapshot.params.idBody;
    this.applicationState.subscribe(() => {
      this.buildFileTree(0).subscribe(value => {
        this.applicationData.next(value);
      });
    });
    this.buildFileTree(0).subscribe(value => {
      this.applicationData.next(value);
    });
  }
  get data(): ApplicationItemNode[] {
    return this.applicationData.value;
  }
  buildFileTree(level: number): Observable<ApplicationItemNode[]> {
    const nodes: ApplicationItemNode[] = [];
    return new Observable((observer) => {
      return this.bodyFaceHairService.findBodyFaceHair(this.idBody).subscribe(body => {
        const categoryRoot = new ApplicationItemNode();
        categoryRoot.name = 'Categories';
        categoryRoot.title = 'More details';
        categoryRoot.clazz = 'fas fa-stream';
        categoryRoot.routerLink = '/tree-application/' + body.id + '/display-body-face-hair/' + body.id;
        nodes.push(categoryRoot);

        if (body.types.length > 0) {
          body.types.forEach((type) => {
            const typeRoot = new ApplicationItemNode();
            typeRoot.name = type.name;
            typeRoot.title = 'More details';
            typeRoot.clazz = 'fas fa-user-ninja';
            typeRoot.routerLink = '/tree-application/' + body.id + '/display-type/' + type.id;
            categoryRoot.children.push(typeRoot);

            if (type.characteristics.length > 0) {
              type.characteristics.forEach((characteristic) => {
                const characteristicRoot = new ApplicationItemNode();
                characteristicRoot.name = characteristic.name;
                characteristicRoot.title = 'More details';
                characteristicRoot.clazz = 'fas fa-drum-steelpan';
                characteristicRoot.routerLink = '/tree-application/' + body.id + '/display-characteristic/' + characteristic.id;
                typeRoot.children.push(characteristicRoot);

                if (characteristic.actifs.length > 0) {
                  characteristic.actifs.forEach((actif) => {
                    const actifRoot = new ApplicationItemNode();
                    actifRoot.name = 'Actifs: ' + '('+actif.name+')';
                    actifRoot.title = 'More details';
                    actifRoot.clazz = 'fab fa-creative-commons-remix';
                    actifRoot.routerLink = '/tree-application/' + body.id + '/find-actif-characteristic/' + actif.id;
                    characteristicRoot.children.push(actifRoot);
                  });
                }
      
                if (characteristic.essentialOils.length > 0) {
                  characteristic.essentialOils.forEach((essential) => {
                    const essentialRoot = new ApplicationItemNode();
                    essentialRoot.name = 'Essentials: '+'('+essential.name+')';
                    essentialRoot.title = 'More details';
                    essentialRoot.clazz = 'fab fa-creative-commons-remix';
                    essentialRoot.routerLink = '/tree-application/' + body.id + '/find-essential-characteristic/' + essential.id;
                    characteristicRoot.children.push(essentialRoot);
                  });
                }
                if (characteristic.products.length > 0) {
                  characteristic.products.forEach((product) => {
                    const productRoot = new ApplicationItemNode();
                    productRoot.name = 'Ingredients: '+'('+product.name+')';
                    productRoot.title = 'More details';
                    productRoot.clazz = 'fab fa-creative-commons-remix';
                    productRoot.routerLink = '/tree-application/' + body.id + '/find-ingredient-characteristic/' + product.id;
                    characteristicRoot.children.push(productRoot);
                  });
                }

                if (characteristic.needs.length > 0) {
                  characteristic.needs.forEach((need) => {
                    const needRoot = new ApplicationItemNode();
                    needRoot.name = need.name;
                    needRoot.title = 'More details';
                    needRoot.clazz = 'fab fa-staylinked';
                    needRoot.routerLink = '/tree-application/' + body.id + '/display-need/' + need.id;
                    characteristicRoot.children.push(needRoot);

                    if (need.baseProducts.length > 0) {
                      need.baseProducts.forEach(base => {
                        const baseRoot = new ApplicationItemNode();
                        baseRoot.name = base.name;
                        baseRoot.title = 'More details';
                        baseRoot.clazz = 'fas fa-bong';
                        baseRoot.routerLink = '/tree-application/' + body.id + '/display-base-product/' + base.id;
                        needRoot.children.push(baseRoot);
                      });
                    }
             
                  })
                }
              })
            }
          })
        }
        
        observer.next(nodes);
      })
    });
  }
}

