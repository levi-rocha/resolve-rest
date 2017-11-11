package br.unifor.resolve.rest.resource;

import br.unifor.resolve.rest.entity.Post;
import br.unifor.resolve.rest.entity.Report;
import br.unifor.resolve.rest.dto.ReportUpdateFields;
import br.unifor.resolve.rest.dto.ReportDTO;
import br.unifor.resolve.rest.entity.User;
import br.unifor.resolve.rest.repository.PostRepository;
import br.unifor.resolve.rest.repository.ReportRepository;
import br.unifor.resolve.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/reports")
public class ReportResource {

    private ReportRepository reportRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public ReportResource(ReportRepository reportRepository, UserRepository userRepository, PostRepository postRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
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
        User author = userRepository.findById(report.getAuthor().getId());
        Post post = postRepository.findById(report.getPost().getId());
        report.setAuthor(author);
        report.setPost(post);
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
    public Long delete(@PathVariable Long id) {
        return reportRepository.deleteById(id);
    }

}
