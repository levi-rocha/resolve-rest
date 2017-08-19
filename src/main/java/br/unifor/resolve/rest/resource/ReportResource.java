package br.unifor.resolve.rest.resource;

import br.unifor.resolve.rest.entity.Report;
import br.unifor.resolve.rest.dto.ReportUpdateFields;
import br.unifor.resolve.rest.dto.ReportDTO;
import br.unifor.resolve.rest.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/report")
public class ReportResource {

    private ReportRepository reportRepository;

    @Autowired
    public ReportResource(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @RequestMapping(method = GET)
    public List<ReportDTO> findAll(Pageable pageable) {
        List<Report> data =
                reportRepository.findAll(pageable).getContent();
        List<ReportDTO> dtos = new ArrayList<>();
        for (Report s : data) {
            dtos.add(ReportDTO.fromReport(s));
        }
        return dtos;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ReportDTO findById(
            @PathVariable Long id) {
        return ReportDTO.fromReport(reportRepository.findById(id));
    }

    @RequestMapping(method = POST)
    public ReportDTO insert(@RequestBody Report report) {
        return ReportDTO.fromReport(reportRepository.save(report));
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    public ReportDTO update(@RequestBody ReportUpdateFields report,
                              @PathVariable Long id) {
        Report found = reportRepository.findById(id);
        if (found == null)
            return null;
        if (report.getDescription() != null)
            found.setDescription(report.getDescription());
        return ReportDTO.fromReport(reportRepository.save(found));
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ReportDTO delete(@PathVariable Long id) {
        return ReportDTO.fromReport(reportRepository
                .deleteById(id));
    }

}
