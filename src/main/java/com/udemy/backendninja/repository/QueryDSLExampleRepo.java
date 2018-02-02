package com.udemy.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public void find() {
		JPAQuery<Course> query = new JPAQuery<Course>(this.em);
		//Obtener un Curso
		Course course = query.select(qCourse).from(qCourse).where(qCourse.id.eq(1)).fetchOne();
		//Obtener un Listado de Cursos
		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	}
	
	
	public Course dslFind( boolean exist ) {
		JPAQuery<Course> query = new JPAQuery<Course>(this.em);
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OT"));
		
		if( exist ) {
			Predicate predicate2 = qCourse.id.eq(1);
			predicateBuilder.and(predicate2);
		}else {
			Predicate predicate3 = qCourse.name.endsWith("PT");
			predicateBuilder.or(predicate3);
		}
		
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
	}
	
	
}
