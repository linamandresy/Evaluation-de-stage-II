import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMajorationComponent } from './update-majoration.component';

describe('UpdateMajorationComponent', () => {
  let component: UpdateMajorationComponent;
  let fixture: ComponentFixture<UpdateMajorationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateMajorationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMajorationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
