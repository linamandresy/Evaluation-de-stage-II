import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertEmployeComponent } from './insert-employe.component';

describe('InsertEmployeComponent', () => {
  let component: InsertEmployeComponent;
  let fixture: ComponentFixture<InsertEmployeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertEmployeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertEmployeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
