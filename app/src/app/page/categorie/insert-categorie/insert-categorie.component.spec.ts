import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertCategorieComponent } from './insert-categorie.component';

describe('InsertCategorieComponent', () => {
  let component: InsertCategorieComponent;
  let fixture: ComponentFixture<InsertCategorieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertCategorieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertCategorieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
