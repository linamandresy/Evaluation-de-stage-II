import { TestBed } from '@angular/core/testing';

import { FicheHorraireService } from './fiche-horraire.service';

describe('FicheHorraireService', () => {
  let service: FicheHorraireService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FicheHorraireService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
