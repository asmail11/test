import { FlatTreeControl } from '@angular/cdk/tree';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatTreeFlattener, MatTreeFlatDataSource } from '@angular/material/tree';
import { ActivatedRoute } from '@angular/router';
import { ApplicationItemFlatNode, ApplicationItemNode, TreeApplicationService } from '../../service/tree-application.service';
import { BodyFaceHairService } from '../../service/body-face-hair.service';
import { BodyFaceHairDto } from 'src/app/modal/rest';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-tree-application',
  templateUrl: './tree-application.component.html',
  styleUrls: ['./tree-application.component.scss'],
  providers: [TreeApplicationService]
})
export class TreeApplicationComponent implements OnInit {
  idBody: number;
  bodyFaceHairDto: BodyFaceHairDto = {} as BodyFaceHairDto;
  flatNodeMap = new Map<ApplicationItemFlatNode, ApplicationItemNode>();
  nestedNodeMap = new Map<ApplicationItemNode, ApplicationItemFlatNode>();

  treeControl: FlatTreeControl<ApplicationItemFlatNode>;
  treeFlattener: MatTreeFlattener<ApplicationItemNode, ApplicationItemFlatNode>;
  dataSource: MatTreeFlatDataSource<ApplicationItemNode, ApplicationItemFlatNode>;
  expandedNodes: ApplicationItemFlatNode[];

  constructor(private route: ActivatedRoute, private bodyFaceHairService: BodyFaceHairService, private dialog: MatDialog,
    private treeApplicationService: TreeApplicationService, private titleService: Title) {
    this.route.params.subscribe(
      params => {
        this.idBody = this.route.snapshot.params.idBody;

        this.treeFlattener = new MatTreeFlattener(this.transform, this.getLevel, this.isExpandable, this.getChildren);
        this.treeControl = new FlatTreeControl<ApplicationItemFlatNode>(this.getLevel, this.isExpandable);
        this.dataSource = new MatTreeFlatDataSource(this.treeControl, this.treeFlattener);
        this.saveExpandedNodes();
        this.restoreExpandedNodes();

        treeApplicationService.applicationData.subscribe(bodyFaceHairDto => {
          this.dataSource.data = bodyFaceHairDto;
        });
        this.treeApplicationService.applicationState.next(this.bodyFaceHairDto);

        this.bodyFaceHairService.findBodyFaceHair(this.idBody).subscribe((bodyFaceHairDto) => {
          this.bodyFaceHairDto = bodyFaceHairDto;
        })
      }
    )
   }

  ngOnInit(): void {

  }
  getLevel = (node: ApplicationItemFlatNode) => node.level;
  isExpandable = (node: ApplicationItemFlatNode) => node.expandable;
  getChildren = (node: ApplicationItemNode): ApplicationItemNode [] => node.children;
  hasChild = (_: number, nodeDate: ApplicationItemFlatNode) => nodeDate.expandable;
  hasNoContent = (_: number, nodeData: ApplicationItemFlatNode) => nodeData.item === '';

    transform = (node: ApplicationItemNode, level: number) => {
    const existingNode = this.nestedNodeMap.get(node);
    const flatNode = existingNode && existingNode.name === node.name ? existingNode : new ApplicationItemFlatNode();
    flatNode.name = node.name;
    flatNode.id = node.id;
    flatNode.clazz = node.clazz;
    flatNode.level = level;
    flatNode.title = node.title;
    flatNode.routerLink = node.routerLink;
    flatNode.actions = node.actions;
    flatNode.expandable = (node.children && node.children.length > 0);
    this.flatNodeMap.set(flatNode, node);
    this.nestedNodeMap.set(node, flatNode);
    return flatNode;
  }
  private saveExpandedNodes() {
    if (this.treeControl && this.treeControl.dataNodes) {
      this.expandedNodes = new Array<ApplicationItemFlatNode>();
      this.treeControl.dataNodes.forEach(node => {
      if (node.expandable && this.treeControl.isExpanded(node)) {
          this.expandedNodes.push(node);
        }
      });
    }
  }

  private restoreExpandedNodes() {
    if (this.expandedNodes && this.expandedNodes.length > 0) {
      this.expandedNodes.forEach(node => {
        this.treeControl.expand(this.treeControl.dataNodes.find(n => n.id === node.id));
      });
    }
  }
  setDocTitle(title: string) {
    console.log('current title -> ' + this.titleService.getTitle());
    this.titleService.setTitle(title);
 }
}