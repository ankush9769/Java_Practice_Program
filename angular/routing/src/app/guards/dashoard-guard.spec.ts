import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';
import { dashoardGuard } from './dashoard-guard';

describe('dashoardGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) =>
    TestBed.runInInjectionContext(() => dashoardGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
