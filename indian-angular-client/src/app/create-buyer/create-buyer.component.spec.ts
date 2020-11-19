import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBuyerComponent } from './create-buyer.component';

describe('CreateBuyerComponent', () => {
  let component: CreateBuyerComponent;
  let fixture: ComponentFixture<CreateBuyerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBuyerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBuyerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
