import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertPointageComponent } from './insert-pointage.component';

describe('InsertPointageComponent', () => {
  let component: InsertPointageComponent;
  let fixture: ComponentFixture<InsertPointageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertPointageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertPointageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
