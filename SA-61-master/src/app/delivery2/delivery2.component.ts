import { Component, OnInit } from '@angular/core';
import { MainService } from '../service/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-delivery2',
  templateUrl: './delivery2.component.html',
  styleUrls: ['./delivery2.component.css']
})
export class Delivery2Component implements OnInit {
  sub: any;
  province: any;
  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.province = params
        console.log(this.province.provinceSelect)
    })
  }

}
