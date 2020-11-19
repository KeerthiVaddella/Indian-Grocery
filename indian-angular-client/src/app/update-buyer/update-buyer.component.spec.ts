import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBuyerComponent } from './update-buyer.component';

describe('UpdateBuyerComponent', () => {
  let component: UpdateBuyerComponent;
  let fixture: ComponentFixture<UpdateBuyerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateBuyerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBuyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
