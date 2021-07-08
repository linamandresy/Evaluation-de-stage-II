import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMajorationComponent } from './list-majoration.component';

describe('ListMajorationComponent', () => {
  let component: ListMajorationComponent;
  let fixture: ComponentFixture<ListMajorationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListMajorationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMajorationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
