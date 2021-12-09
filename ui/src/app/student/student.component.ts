import {
  Component,
  Inject,
  Injector,
  Input,
  OnChanges,
  OnInit,
  SimpleChanges
} from '@angular/core';
import {
  ControlValueAccessor,
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import {
  Location
} from '@angular/common';
import {
  MatDialog,
  MAT_DIALOG_DATA
} from '@angular/material/dialog';
import {
  ActivatedRoute, Router
} from '@angular/router';
import {
  Student
} from '../model/student';
import {
  AppConfigService
} from '../service/app-config.service';
import {
  StudentService
} from '../service/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit, OnChanges, ControlValueAccessor  {

  public useMockGrade;

  public form: FormGroup;

  private linkId!: string;

  public student!: Student;

  service: any;
  onChange: any;
  onTouched: any;
  ethnicityId: any;

  constructor(
    protected config: AppConfigService,
    private route: ActivatedRoute, 
    private router: Router,
    private formBuilder: FormBuilder,
    private studentService: StudentService
  ) {
    this.useMockGrade = config.getConfig().useMockGrade;
    //IFD: console.log(data);
    this.form = this.formBuilder.group({
      id: [null],
      ethnicityId: [null, Validators.required],
      offerAccepted: ['', Validators.required],
      studentSignature: ['', Validators.required],
      studentSignatureDate: ['', Validators.required],
      parentSignature: ['', Validators.required],
      parentSignatureDate: ['', Validators.required],
      lookedAfterChildOrAdopted: [''],
      childrenServicesInvolvedAtSchool: [''],
      otherSocialSupportIssues: [''],
      freeMealsWhileAtSchool: [''],
      parentsUniversityEducated: [''],
      contactByPost: [''],
      contactByEmail: [''],
      contactByPhone: [''],
      ehcp: [''],
      llddHealthProblemId: [null, Validators.required ]
    });

  }
  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }
  writeValue(value: any) {
    if (value) {
      this.ethnicityId = value;
    }
  }
  registerOnChange(fn: any) { this.onChange = fn;  }

  registerOnTouched(fn: any) { this.onTouched = fn; }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.linkId = params['LinkId'];
      this.getStudent();

    });
  }


  getStudent(): void {
    if (this.linkId !== undefined) {
      this.studentService.getByLinkId(this.linkId).subscribe(student => {
        this.student = student;
        this.form.patchValue({
          id: student.id,
          offerAccepted: false,
          lookedAfterChildOrAdopted: false,
          childrenServicesInvolvedAtSchool: false,
          otherSocialSupportIssues: false,
          freeMealsWhileAtSchool: false,
          parentsUniversityEducated: false,
          contactByPost: false,
          contactByEmail: false,
          contactByPhone: false,
          ehcp: false,
        })
        console.log(student);
      });
    }
  }


  saveApplication(student: any): void {
    console.log("Save button trigerred");
    console.log(this.form.value);
    const data = this.form.value;
    const id = student.id;
    this.studentService.save(data, id).subscribe({
      next: res => {
        // disable form
        this.form.disable();
        console.log("Application is successful");                                            
      },
      error: err => {
              console.log("Application Unsuccessful");            
              this.router.navigate(['application-confirmation']);                                  
      }
  });
  }

}
