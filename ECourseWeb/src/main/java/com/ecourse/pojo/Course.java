/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecourse.pojo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findById", query = "SELECT c FROM Course c WHERE c.id = :id"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description"),
    @NamedQuery(name = "Course.findByIsActive", query = "SELECT c FROM Course c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "Course.findByCreatedDate", query = "SELECT c FROM Course c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Course.findByUpdatedDate", query = "SELECT c FROM Course c WHERE c.updatedDate = :updatedDate"),
    @NamedQuery(name = "Course.findByPrice", query = "SELECT c FROM Course c WHERE c.price = :price"),
    @NamedQuery(name = "Course.findByDiscount", query = "SELECT c FROM Course c WHERE c.discount = :discount"),
    @NamedQuery(name = "Course.findByImage", query = "SELECT c FROM Course c WHERE c.image = :image")})
public class Course implements Serializable {

//    @OneToMany(mappedBy = "course")
//    private Set<Lesson> lessonSet;
//    @OneToMany(mappedBy = "course")
//    private Set<Video> videoSet;
//
//    @OneToMany(mappedBy = "courseId")
//    private Set<CourseProcess> courseprocessSet;
//
//    @OneToMany(mappedBy = "courseId")
//    private Set<ReceiptDetail> receiptDetailSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "isActive")
    private Boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private float discount;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
//    @OneToMany(mappedBy = "courseId")
//    @JsonIgnore
//    private Set<Lesson> lessonSet;
//    @OneToMany(mappedBy = "courseId")
//    @JsonIgnore
//    private Set<Video> videoSet;
//    @OneToMany(mappedBy = "courseId")
//    @JsonIgnore
//    private Set<Certification> certificationSet;
//    @OneToMany(mappedBy = "courseId")
//    @JsonIgnore
//    private Set<Enrollment> enrollmentSet;
//    @OneToMany(mappedBy = "courseId")
//    @JsonIgnore
//    private Set<ReceiptDetail> recepitDetailSet;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne
  
    private Category categoryId;
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    @ManyToOne
    private Tag tagId;
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Teacher teacherId;
    @Transient
    private MultipartFile file;
    
    @PrePersist
    protected void onCreate() {
        this.createdDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = new Date();
    }
    public Course() {
    }

    public Course(Long id) {
        this.id = id;
    }

    public Course(Long id, String name, Date createdDate, Date updatedDate, float price, float discount) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.price = price;
        this.discount = discount;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    @XmlTransient
//    public Set<Lesson> getLessonSet() {
//        return lessonSet;
//    }
//
//    public void setLessonSet(Set<Lesson> lessonSet) {
//        this.lessonSet = lessonSet;
//    }

//    @XmlTransient
//    public Set<Video> getVideoSet() {
//        return videoSet;
//    }
//
//    public void setVideoSet(Set<Video> videoSet) {
//        this.videoSet = videoSet;
//    }
//
//    @XmlTransient
//    public Set<Certification> getCertificationSet() {
//        return certificationSet;
//    }
//
//    public void setCertificationSet(Set<Certification> certificationSet) {
//        this.certificationSet = certificationSet;
//    }
//
//    @XmlTransient
//    public Set<Enrollment> getEnrollmentSet() {
//        return enrollmentSet;
//    }
//
//    public void setEnrollmentSet(Set<Enrollment> enrollmentSet) {
//        this.enrollmentSet = enrollmentSet;
//    }
//
//    @XmlTransient
//    public Set<ReceiptDetail> getRecepitDetailSet() {
//        return recepitDetailSet;
//    }
//
//    public void setRecepitDetailSet(Set<ReceiptDetail> recepitDetailSet) {
//        this.recepitDetailSet = recepitDetailSet;
//    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Tag getTagId() {
        return tagId;
    }

    public void setTagId(Tag tagId) {
        this.tagId = tagId;
    }

    public Teacher getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Teacher teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ecourse.pojo.Course[ id=" + id + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

//    @XmlTransient
//    public Set<ReceiptDetail> getReceiptDetailSet() {
//        return receiptDetailSet;
//    }
//
//    public void setReceiptDetailSet(Set<ReceiptDetail> receiptDetailSet) {
//        this.receiptDetailSet = receiptDetailSet;
//    }

//    @XmlTransient
//    public Set<CourseProcess> getCourseprocessSet() {
//        return courseprocessSet;
//    }
//
//    public void setCourseprocessSet(Set<CourseProcess> courseprocessSet) {
//        this.courseprocessSet = courseprocessSet;
//    }
//
//    @XmlTransient
//    public Set<Lesson> getLessonSet() {
//        return lessonSet;
//    }
//
//    public void setLessonSet(Set<Lesson> lessonSet) {
//        this.lessonSet = lessonSet;
//    }
//
//    @XmlTransient
//    public Set<Video> getVideoSet() {
//        return videoSet;
//    }
//
//    public void setVideoSet(Set<Video> videoSet) {
//        this.videoSet = videoSet;
//    }
    
}
