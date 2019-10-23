import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarMatchesComponent } from './listar-matches.component';

describe('ListarMatchesComponent', () => {
  let component: ListarMatchesComponent;
  let fixture: ComponentFixture<ListarMatchesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarMatchesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarMatchesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
