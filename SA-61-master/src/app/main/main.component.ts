import { Component, OnInit } from '@angular/core';
import { MainService } from '../service/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  private province :any;
  //item: Array <any>;
  transport: Array <any>;

  cus : any ={
    id : '',
    username : '',
    customerName : '',
    tel : '',
    email : ''
  };

  item: any = {
    itemId: '',
    itemName: '',
    price: '',
    itemNum: ''
  };


  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute){}

  ngOnInit() {
    this.rout.params.subscribe(prams=>{
        this.province = prams
        console.log(prams)
    })

    this.mainService.getItem().subscribe(data => {
      this.item = data;
      console.log(this.item);
    });

  }
  add() {

    if (this.contactSet.contact === '' || this.contactSet.type === ''){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else {
      this.httpClient.post('http://localhost:8080/newContact/' + this.manager.username + '/' + this.contactSet.type + '/' +
        this.contactSet.contact,this.contactSet)
      .subscribe(
        data => {
          if(data) {
            alert('เพิ่มข้อมูลการติดต่อสำเร็จ');
            location.reload();
            console.log('PUT Request is successful', data);
          }
        },
        error => {
          console.log('Error', error);
        }
      );
    }
  }

}
