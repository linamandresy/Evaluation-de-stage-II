import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListHsComponent } from './list-hs.component';

describe('ListHsComponent', () => {
  let component: ListHsComponent;
  let fixture: ComponentFixture<ListHsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListHsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListHsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
