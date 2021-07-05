import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertHsComponent } from './insert-hs.component';

describe('InsertHsComponent', () => {
  let component: InsertHsComponent;
  let fixture: ComponentFixture<InsertHsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertHsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertHsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
