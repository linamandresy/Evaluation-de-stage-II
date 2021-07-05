import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSemaineComponent } from './list-semaine.component';

describe('ListSemaineComponent', () => {
  let component: ListSemaineComponent;
  let fixture: ComponentFixture<ListSemaineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSemaineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSemaineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
