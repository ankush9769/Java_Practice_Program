import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Formwithsignal } from './formwithsignal';

describe('Formwithsignal', () => {
  let component: Formwithsignal;
  let fixture: ComponentFixture<Formwithsignal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Formwithsignal],
    }).compileComponents();

    fixture = TestBed.createComponent(Formwithsignal);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
