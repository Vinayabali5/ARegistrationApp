import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() student = {
    legalSurname: 'Balakrishna',
    legalFirstName: 'Vinaya',
    dob: '22/11/2005',
    schoolName: 'Reigate College',
    offerAccepted: true,
    interviewDate: '01/11/2021'    
  }

}
