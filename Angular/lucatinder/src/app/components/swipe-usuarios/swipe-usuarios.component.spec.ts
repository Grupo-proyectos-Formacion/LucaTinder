import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwipeUsuariosComponent } from './swipe-usuarios.component';

describe('SwipeUsuariosComponent', () => {
  let component: SwipeUsuariosComponent;
  let fixture: ComponentFixture<SwipeUsuariosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwipeUsuariosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwipeUsuariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
