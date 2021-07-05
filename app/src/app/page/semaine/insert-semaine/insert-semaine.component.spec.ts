import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertSemaineComponent } from './insert-semaine.component';

describe('InsertSemaineComponent', () => {
  let component: InsertSemaineComponent;
  let fixture: ComponentFixture<InsertSemaineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertSemaineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertSemaineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
