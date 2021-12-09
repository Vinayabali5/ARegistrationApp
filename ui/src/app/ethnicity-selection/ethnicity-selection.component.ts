import { Component, OnInit, Input, Output, EventEmitter, forwardRef, HostBinding, Attribute } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl, ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';
import { EthnicityService } from '../ethnicity.service';
import { Ethnicity } from '../model/ethnicity';

@Component({
  selector: 'ethnicity-selection',
  templateUrl: './ethnicity-selection.component.html',
  styleUrls: ['./ethnicity-selection.component.css'],
  providers:[
    {
        provide: NG_VALUE_ACCESSOR,
        useExisting: forwardRef(() => EthnicitySelectionComponent),
        multi: true,
    },
],
})
export class EthnicitySelectionComponent implements OnInit, ControlValueAccessor {
    @HostBinding('attr.id') externalId = null;
    @HostBinding('attr.class') externalClass = null;
  
    public data: any;
    public error: any;

  constructor(private service: EthnicityService,
    @Attribute('class') public classAttr: string) {
   }

   ngOnInit(): void {
    this.getEthnicities()
  }


  /**
     * HTML Element ID attribute
     */
    @Input()
    private _id: any | undefined;

    /**
     * HTML Element value attribute
     */
    @Input('value')
    private _value: number | undefined;

    /**
     * Register HTML events
     */
    onChange: any = () => {};
    onTouched: any = () => {};

    /**
     * This method is used to retrieve the data for this selection box.
     */
     getEthnicities(){
      this.service.getEthnicities().subscribe(
        res => (this.data = res),
        error => (this.error= <any>error)
      );
    }

    /**
     * This method is used on the onChange event of the select to set the value of the selection box.
     */
    changeValue(e: any): void {
        const value = e.target.value === 'null' ? null : e.target.value;
        this.value = value;
    }

    /**
     * Setter for the ID attribute.
     */
    @Input()
    set id(value: string) {
        this._id = value;
    }

    /**
     * Getter for the ID attribute.
     */
    get id(): string {
        return this._id;
    }

    /**
     * Setter for the value attribute.
     */
    set value(val: number | undefined) {
        console.log(`Ethncity set to: ${val}`);
        this._value = val;
        this.onChange(val);
        this.onTouched();
    }

    /**
     * Getter for the value attribute.
     */
    @Input()
    get value(): number | undefined {
        return this._value;
    }

    // Interface Implementations

    registerOnChange(fn: any): void {
        this.onChange = fn;
    }

    writeValue(value: number): void {
        if (value) {
            this.value = value;
        }
    }

    registerOnTouched(fn: any): void {
        this.onTouched = fn;
    }

}
